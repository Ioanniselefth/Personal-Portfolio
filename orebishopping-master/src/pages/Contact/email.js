const express = require("express");
const nodemailer = require("nodemailer");
const cors = require("cors");
const bodyParser = require("body-parser");

const app = express();
app.use(cors());
app.use(bodyParser.json());

app.post("/send-email", async (req, res) => {
    const { clientName, email, messages } = req.body;

    // Configure Nodemailer
    let transporter = nodemailer.createTransport({
        service: "gmail", // or your email service
        auth: {
            user: "your-email@gmail.com", // Your email
            pass: "your-email-password", // Your email password
        },
    });

    // Prepare email options
    let mailOptions = {
        from: email, // Sender's email
        to: "your-personal-email@gmail.com", // Your personal email
        subject: "New Message from Contact Form",
        text: `You have received a new message from ${clientName} (${email}):\n\n${messages}`,
    };

    // Send email
    try {
        await transporter.sendMail(mailOptions);
        res.status(200).send("Email sent successfully!");
    } catch (error) {
        res.status(500).send("Failed to send email.");
    }
});

app.listen(5000, () => {
    console.log("Server is running on port 5000");
});

app.get("/", (req, res) => {
    res.send("Server is running. You can use the contact form to send an email.");
});
#1587. Bank Account Summary II
SELECT Users.name, SUM(amount) as balance
FROM Users
JOIN Transactions ON Users.account = Transactions.account
GROUP BY Transactions.account HAVING balance>10000;
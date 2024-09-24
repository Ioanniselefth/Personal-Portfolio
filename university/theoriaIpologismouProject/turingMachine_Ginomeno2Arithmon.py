class TuringMachine:
    def __init__(self, tape, blank_symbol="B"):
        self.tape = list(tape)
        self.head = 0
        self.blank_symbol = blank_symbol
        self.state = 'q0'
        self.transitions = {
            ('q0', '1'): ('q1', 'X', 'R'),
            ('q1', '1'): ('q1', '1', 'R'),
            ('q1', '#'): ('q2', '#', 'R'),
            ('q2', '1'): ('q3', 'Y', 'R'),
            ('q2', 'B'): ('q5', 'B', 'L'),
            ('q3', '1'): ('q3', '1', 'R'),
            ('q3', 'B'): ('q4', '1', 'L'),
            ('q4', '1'): ('q4', '1', 'L'),
            ('q4', 'Y'): ('q2', 'Y', 'R'),
            ('q4', '#'): ('q4', '#', 'L'),
            ('q4', 'X'): ('q0', 'X', 'R'),
            ('q5', 'Y'): ('q5', '1', 'L'),
            ('q5', '#'): ('q5', '#', 'L'),
            ('q5', '1'): ('q5', '1', 'L'),
            ('q5', 'X'): ('HALT', 'B', 'R'),
        }

    def step(self):
        current_symbol = self.tape[self.head]
        action = self.transitions.get((self.state, current_symbol))

        if action:
            new_state, new_symbol, direction = action
            self.tape[self.head] = new_symbol
            self.state = new_state

            if direction == 'R':
                self.head += 1
            elif direction == 'L':
                self.head -= 1

            if self.head < 0:
                self.tape.insert(0, self.blank_symbol)
                self.head = 0
            elif self.head >= len(self.tape):
                self.tape.append(self.blank_symbol)

    def run(self):
        while self.state != 'HALT':
            self.step()

    def __str__(self):
        return f'State: {self.state}, Head: {self.head}, Tape: {"".join(self.tape)}'


# Παράδειγμα χρήσης
tape = list('111#11B')  # Εισαγωγή: 3 x 2
tm = TuringMachine(tape)

print(f'Αρχική κατάσταση: {tm}')

tm.run()

print(f'Τελική κατάσταση: {tm}')

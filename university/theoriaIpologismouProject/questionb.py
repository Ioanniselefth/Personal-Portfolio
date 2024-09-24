class TuringMachine:
    def __init__(self, tape, blank_symbol='_'):
        self.tape = list(tape)
        self.blank_symbol = blank_symbol
        self.head = 0
        self.state = 'q0'
        self.step_count = 0
        self.transitions = {
            ('q0', '0'): ('q0', 'X', 'R'),
            ('q0', '1'): ('q0', 'Y', 'R'),
            ('q0', '_'): ('q1', '_', 'L'),
            ('q1', 'X'): ('q1', 'X', 'L'),
            ('q1', 'Y'): ('q1', 'Y', 'L'),
            ('q1', '_'): ('q2', '_', 'R'),
            ('q2', 'X'): ('qf', 'X', 'N'),
            ('q2', 'Y'): ('q2', 'Y', 'R'),
            ('q2', '_'): ('qf', '_', 'N'),
        }

    def step(self):
        char_under_head = self.tape[self.head] if self.head < len(self.tape) else self.blank_symbol
        print(f"Step: {self.step_count}, State: {self.state}, Head: {self.head}, Tape: {''.join(self.tape)}")

        if (self.state, char_under_head) in self.transitions:
            new_state, write_char, direction = self.transitions[(self.state, char_under_head)]
            if self.head < len(self.tape):
                self.tape[self.head] = write_char
            else:
                self.tape.append(write_char)

            if direction == 'R':
                self.head += 1
            elif direction == 'L':
                self.head -= 1

            self.state = new_state
            self.step_count += 1
            return True
        else:
            return False

    def execute(self, max_steps=1000):
        while self.step_count < max_steps and self.step():
            pass
        print(f"Final Tape: {''.join(self.tape).rstrip(self.blank_symbol)}, Total Steps: {self.step_count}")

inputs = ["0110", "1100"]

for input_string in inputs:
    tm = TuringMachine(tape=input_string)
    print(f"Input: {input_string}")
    tm.execute()
    print("\n")

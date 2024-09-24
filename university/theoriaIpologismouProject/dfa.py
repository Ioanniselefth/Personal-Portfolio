class DFA:
    def __init__(self):
        # Καθορισμός των καταστάσεων και των μεταβάσεων
        self.transitions = {
            'q0': {'a': 'q1', 'b': 'q0'},
            'q1': {'a': 'q2', 'b': 'q1'},
            'q2': {'a': 'q3', 'b': 'q2'},
            'q3': {'a': 'q4', 'b': 'q3'},
            'q4': {'a': 'q4', 'b': 'q4'}
        }
        self.start_state = 'q0'
        self.accept_state = 'q3'
        self.current_state = self.start_state

    def reset(self):
        self.current_state = self.start_state

    def process_input(self, input_string):
        for symbol in input_string:
            if symbol in self.transitions[self.current_state]:
                self.current_state = self.transitions[self.current_state][symbol]
            else:
                return False
        return self.current_state == self.accept_state

    def is_accepted(self, input_string):
        self.reset()
        return self.process_input(input_string)

# Δημιουργία του DFA
dfa = DFA()

# Παραδείγματα ελέγχου
examples = ['aaab', 'aaa', 'aab', 'aabb', 'bbaaa', 'aaabb']

for example in examples:
    result = dfa.is_accepted(example)
    print(f"Η συμβολοσειρά '{example}' είναι {'αποδεκτή' if result else 'μη αποδεκτή'} από το DFA.")

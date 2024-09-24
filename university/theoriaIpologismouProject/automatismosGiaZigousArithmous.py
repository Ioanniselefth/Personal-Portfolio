class FiniteAutomaton:
    def __init__(self):
        self.state = 'q0'
        self.transitions = {
            ('q0', '0'): 'q0',
            ('q0', '1'): 'q1',
            ('q1', '0'): 'q1',
            ('q1', '1'): 'q2',
            ('q2', '0'): 'q2',
            ('q2', '1'): 'q1',
        }
        self.accept_states = {'q0'}

    def process_input(self, input_string):
        for symbol in input_string:
            current_state = self.state
            if (self.state, symbol) in self.transitions:
                self.state = self.transitions[(self.state, symbol)]
                print(f'Transition: ({current_state}, {symbol}) -> {self.state}')
            else:
                print(f'Invalid transition: ({current_state}, {symbol})')
                return False
        return self.state in self.accept_states

    def reset(self):
        self.state = 'q0'

    def __str__(self):
        return f'State: {self.state}'

# Παράδειγμα χρήσης
fa = FiniteAutomaton()

# Δοκιμαστική ακολουθία που θα αναγνωριστεί
test_string = "0011"  # Περιέχει ζυγό αριθμό από 0 και ζυγό αριθμό από 1

fa.reset()
print(f'Processing input: {test_string}')
if fa.process_input(test_string):
    print(f'H ακολουθία {test_string} γίνεται αποδεκτή.')
else:
    print(f'H ακολουθία {test_string} δεν γίνεται αποδεκτή.')
print()

# Δοκιμαστική ακολουθία που δεν θα αναγνωριστεί
test_string = "011"  # Περιέχει ζυγό αριθμό από 0 και μονό αριθμό από 1

fa.reset()
print(f'Processing input: {test_string}')
if fa.process_input(test_string):
    print(f'H ακολουθία {test_string} γίνεται αποδεκτή.')
else:
    print(f'H ακολουθία {test_string} δεν γίνεται αποδεκτή.')

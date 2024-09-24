def automaton(sequence):
    # Αρχική κατάσταση
    state = 'q0'
    print(f"Initial state: {state}")
    
    # Διάσχιση της ακολουθίας
    for char in sequence:
        previous_state = state
        if state == 'q0':
            if char == '0':
                state = 'q0'  # Παραμένουμε στην q0
            elif char == '1':
                state = 'q1'  # Μετάβαση στην q1
        elif state == 'q1':
            if char == '0':
                state = 'q3'  # Μετάβαση στην q3 (κατάσταση αποδοχής)
            elif char == '1':
                state = 'q2'  # Μετάβαση στην q2
        elif state == 'q2':
            if char == '0':
                state = 'q0'  # Επιστροφή στην q0
            elif char == '1':
                state = 'q1'  # Μετάβαση στην q1
        elif state == 'q3':
            if char == '0':
                state = 'q0'  # Επιστροφή στην q0
            elif char == '1':
                state = 'q0'  # Επιστροφή στην q0
        
        # Εκτύπωση της μετάβασης
        print(f"Read '{char}': {previous_state} -> {state}")
    
    # Επιστροφή αν η τελική κατάσταση είναι η κατάσταση αποδοχής
    is_accepted = state == 'q3'
    print(f"Final state: {state}, Accepted: {is_accepted}")
    return is_accepted

# Δοκιμές
test_sequences = [
    ("010", True),
    ("0110", True),
    ("01010", True),
    ("01110", True),
    ("011", False),
    ("110", False),
    ("110110", False),
    ("1110", True),
]

for sequence, expected in test_sequences:
    print(f"\nTesting sequence: {sequence}")
    result = automaton(sequence)
    print(f"Expected: {expected} | Result: {result}\n")

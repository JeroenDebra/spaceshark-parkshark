VALID PHONENUMBERS {

^ # Assert position at the beginning of the string.
\+ # Match a literal "+" character.
(?: # Group but don't capture:
[0-9] # Match a digit.
\\s # Match a space character
? # between zero and one time.
) # End the noncapturing group.
{6,14} # Repeat the group between 6 and 14 times.
[0-9] # Match a digit.
$ # Assert position at the end of the string.


+1 1234567890123 : true
+12 123456789 : true
+123 123456 : true

}

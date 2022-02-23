def encrypt(plaintext, key):
    ciphertext = ''
    plaintext = plaintext.upper()
    for i in str(plaintext):
        if (i == ' '):
            ciphertext += ' '
        else : 
            ciphertext += chr((ord(i) + key - 65) % 26 + 65)

    return ciphertext

def decrypt(ciphertext, key):
    plaintext = ''
    for i in str(ciphertext):
        if (i == ' '):
            plaintext += ' '
        else: 
            plaintext += chr((ord(i) - key - 65) % 26 + 65)
    return plaintext



message = input('Input your message: ')
key = int(input('Input the key (a number [0-25]): '))
encrypted = encrypt(message, key)
decrypted = decrypt(encrypted, key)
print(f' \n'+
f'encrypted message : {encrypted} \n'+
f'decrypted message : {decrypted} \n')

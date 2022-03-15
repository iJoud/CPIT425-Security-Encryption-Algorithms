from Crypto.Cipher import DES3
from Crypto.Random import get_random_bytes

Key = ''

def Encrypte(plaintext):
    global cipher
    nonce = cipher.nonce
    ciphertext = cipher.encrypt(plaintext.encode('ascii'))
    return ciphertext, nonce


def Decrypt(nonce, ciphertext):
    global cipher
    cipher = DES3.new(Key,DES3.MODE_EAX, nonce=nonce)
    plaintext = cipher.decrypt(ciphertext)
    return plaintext.decode('ascii')


def GenerateKey ():
    while True:
        global Key
        try:
            Key = DES3.adjust_key_parity(get_random_bytes(24))
            break
        except:
            pass # empty code not allowed


GenerateKey()
plaintext = input('Enter message to encrypt: ')
cipher = DES3.new(Key, DES3.MODE_EAX)
ciphertext, nonce = Encrypte(plaintext)
originaltext = Decrypt(nonce, ciphertext)
print(f'Generated Key : {Key} \nEncrypted Message : {cipher}, \nDecrypted Message : {originaltext}')

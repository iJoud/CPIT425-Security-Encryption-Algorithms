import rsa

msg = str(input('Enter Message To Encrypte & Sign: '))
EncodedMessage = msg.encode('ascii')
# Generate RSA Key Pairs
# Only defines 1024, 2048 or 3072
publicKey, privateKey = rsa.newkeys(2048)

# Encrypt message using private key
EncryptedMessage = rsa.encrypt(EncodedMessage, publicKey)
print('\n (1) Encrypted Message : \n',bytes(EncryptedMessage),'\n\n')

# Sign Encrypted Message using SHA-1 Algorithm
SignedMessage = rsa.sign(EncodedMessage, privateKey, 'SHA-1')
print('\n (2) Digital Signature : \n',bytes(SignedMessage),'\n\n')

# Verify Encrypted Message
VerifySignature = rsa.verify(EncodedMessage, SignedMessage, publicKey) == 'SHA-1'
print('\n (3) Is The Digital Signature Verified Correctly? : ', VerifySignature, '\n\n')

# Decrypt Message 
DecryptedMessage = rsa.decrypt(EncryptedMessage, privateKey)
print('\n (4) Decrypted Message : ', DecryptedMessage, '\n\n')

# Recover Original Message
OriginalMessage = DecryptedMessage.decode('ascii')
print('\n (5) Original Message : ', OriginalMessage, '\n\n')


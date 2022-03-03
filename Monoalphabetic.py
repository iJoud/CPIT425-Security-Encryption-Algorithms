def ConvertToChar(number):
    return chr(number+97)


def ConvertToNumber(Char):
    return int(Char-97)


def Encrypt(plainText, key):
    keyList = []
    for i in range(26):
        keyList.append(ConvertToNumber(ord(key[i])))

    cipherText = ''
    for i in str(plainText):
        cipherText += ConvertToChar(keyList[int(ConvertToNumber(ord(i)))])
    return cipherText


def Decrypt(cipherText, key):
    OriginalText = ''
    keyList = []
    InvertedKey = [None] * 26

    for i in range(26):
        keyList.append(ConvertToNumber(ord(key[i])))

    # Generate Inverted Key
    for i in range(26):
        for j in range(26):
            if (j == keyList[i]):
                InvertedKey[j] = i
                break

    for i in range(len(cipherText)):
        OriginalText += ConvertToChar(InvertedKey[ConvertToNumber(ord(cipherText[i]))])

    return OriginalText


plainText = input('Input your message to encrypt: ').lower()
# The key is all alphabet in special order you choose
# examole of possible key: DKVQFIBJWPESCXHTMYAUOLRGZN
key = input('Input monoalphabetic key: ').lower()

ciperText = Encrypt(plainText, key)
print(f'\nEncrypted: {ciperText}\n'
      + f'Decrypted: {Decrypt(ciperText, key)}')

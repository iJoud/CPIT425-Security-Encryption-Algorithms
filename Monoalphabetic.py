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
        index = ConvertToNumber(ord(cipherText[i]))
        OriginalText += ConvertToChar(InvertedKey[index])

    return OriginalText


plainText = input('Input your message to encrypt: ').lower()
key = input('Input monoalphabetic key: ').lower()

ciperText = Encrypt(plainText, key)
print(f'\nencrypted: {ciperText}\n'
      + f'decrypted: {Decrypt(ciperText, key)}')

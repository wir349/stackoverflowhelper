import sys
import googleapi
import stackapi

def main(argv):
    lst = googleapi.getGoogleResults(argv[0])
    for item in lst:
        stackapi.getSOApiResults(item)

if __name__ == "__main__":
    main(sys.argv[1:])
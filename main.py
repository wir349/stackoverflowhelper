import sys
import googleapi
import stackapi

def main(argv):
    lst = googleapi.getGoogleResults(argv)
    if lst:
        print stackapi.getSOApiResults(lst[0])

if __name__ == "__main__":
    main(sys.argv[1:])
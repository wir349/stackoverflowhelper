import pprint
from googleapiclient.discovery import build
import stackapi

API_KEY = "AIzaSyCJLui_HD-THLZkEmBmWvfsj1GLjCx_M9A"
CSE_ID = "008171140621555576608:krdkbofgvt8"

# takes code input

def getInput():
    # print("Hello World")
    inputText = raw_input("Enter The Code you want to search for:")
    return inputText

def getGoogleResults(string):
	service = build("customsearch", "v1", developerKey=API_KEY)

	res = service.cse().list(q='something', cx=CSE_ID).execute()
	items = res['items']
	soId = []
	for item in items:
	    # pprint.pprint(item)
	    if item['link'].startswith("http://stackoverflow.com/questions/"): 
	    	nextSlash = item['link'][35:].find('/')
	    	if nextSlash != -1:
			    # pprint.pprint(item['link'][30:])
			    #print(item['link'][35:35+nextSlash])
			    soId.append(item['link'][35:35+nextSlash])
	return soId

def main():
    lst = getGoogleResults(getInput())
    print(lst)
    for item in lst:
    	stackapi.getSOApiResults(item)
main()



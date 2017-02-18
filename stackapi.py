import stackexchange
from bs4 import BeautifulSoup
import urllib2


class queans:
    def __init__(self, up, text):
        self.u = up
        self.t = text


s = stackexchange.Site("api.stackoverflow.com")
q = s.question(35988)
a = q.answers[1].id
qu = s.question(35988).url
# print qu


response = urllib2.urlopen(qu)
data = response.read()

soup = BeautifulSoup(data, 'html.parser')
st = soup.get_text()

deans = 'share|improve this answer'
upv = 'up vote'

f1a = 0
f2a = 0
ii = 100
i = 0
iii = 0
qn = []
qa = []
while (f1a != -2):
    f1a = st.find(deans, f1a)
    f2a = f1a + 50
    # print f2a, 'hi'
    # print f1a, 'lol'
    ii = 10
    while (f2a > f1a or f2a == -1):
        f2a = st.find(upv, f1a - ii)
        ii = ii + 100
        # print f2a
        # print ii
    f1a = f1a + 30
    # print f2a, 'hi22'
    ttxt = st[f2a + 20:f1a - 30]
    iii = f2a + 8
    qa = []
    while (st[iii] >= '0' and st[iii] <= '9'):
        qa.append(st[iii])

        iii = iii + 1

    # print ''.join(qa)  
    qn.append(queans(int(''.join(qa)), ttxt))
    i = i + 1
    print '---------------------------------------------------------------'
    print 'Up Vote number is:       ', qn[i - 1].u
    print '\n\nText body of the answer is: \n\n', qn[i - 1].t

    # print st.find(deans, f1a)
    if (st.find(deans, f1a) == -1):
        break;

        # print st[13300:13412+600]  
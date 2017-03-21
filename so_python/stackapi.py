from stackexchange import Site, StackOverflow

so = Site(StackOverflow)
so.be_inclusive()

def getScore(a):
    return a.score

def getSOApiResults(qid):
    answers = so.question(qid).answers
    print so.question(qid)
    print("Link: http://stackoverflow.com/questions/" + qid)
    return sorted(answers, key=getScore, reverse=True)

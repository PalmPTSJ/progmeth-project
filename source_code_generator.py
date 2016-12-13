from os import listdir
from os.path import isfile, join
getFileList = lambda mypath:[join(mypath,f) for f in listdir(mypath) if isfile(join(mypath, f))]
arr=["src/application","src/exception","src/logic","src/model","src/model/enemy","src/model/projectile","src/model/tileObject","src/model/tileObject/generator","src/model/tileObject/storage","src/model/tileObject/tower","src/thread","src/ui","src/ui/research"]
arr2=[]
for i in arr:
	arr2+=getFileList(i)
#print(len(arr2))
#print(arr2)
for i in arr2:
	print("/* "+i+" */")
	print(open(i).read())

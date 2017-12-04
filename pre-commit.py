#!/bin/bash
# -*- coding: cp1252 -*-
import git
import os
import sys
from git import Repo
import subprocess

#repo = git.Git(".")
#print repo
repo = git.Repo('C:\Users\csrinivasan\Desktop\Final\Rialto\Automation')
#repo = git.Repo()
print repo
count_modified_files = len(repo.index.diff(None))
count_staged_files = len(repo.index.diff("HEAD"))
print count_modified_files, count_staged_files
staged_files = repo.index.diff("HEAD")
for x in staged_files:
    print(x.a_path)
    file_object  = open(x.a_path, 'r')
    if '//@AfterMethod' in open(x.a_path).read():
        print "After Method is commented,Please uncomment it"
        sys.exit(-1)
        print "It will not execute"
    #print file_object.read()

#proc = subprocess.Popen(['git', 'diff', '--name-only', '--cached'], stdout=subprocess.PIPE)
#staged_files = proc.stdout.readlines()
#staged_files = [f.decode('utf-8') for f in staged_files]
#staged_files = [f.strip() for f in staged_files]
#print(staged_files[0])

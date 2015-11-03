#!/usr/bin/env python2.7

import pypandoc
import os

DOCPATH = os.path.realpath(os.path.join(os.path.
            dirname(__file__), "../docs"))
DR_PATH = os.path.realpath(os.path.join(os.path.
            dirname(__file__), "../docs", "Design_Report.md"))
AM_PATH = os.path.realpath(os.path.join(os.path.
            dirname(__file__), "../docs", 
                "Administration_manual.md"))
DM_PATH = os.path.realpath(os.path.join(os.path.
            dirname(__file__), "../docs", 
                "Developers_manual.md"))
folders = {"admin" : AM_PATH, "dev" : DM_PATH, 
            "design" : DR_PATH}

for key, value in folders.iteritems():
    newFolder = os.path.join(os.path.join(DOCPATH, key))
    if not os.path.exists(newFolder):
        os.makedirs(newFolder)
    pypandoc.convert(value, 'html', format='markdown', outputfile=os.path.join(newFolder, 'index.html'))
#print 'value is %s' % value
#print 'newfolder is %s' % newFolder

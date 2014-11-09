import sys;
import re
fileName = sys.argv[1]
outfile = sys.argv[2]
with open(outfile, 'w') as out:
    with open (fileName) as data:
        for line in data:
            #group = re.match(r"(.*?)([0-9]+)",line.strip()) 
            g = re.match(r"(.*?)([0-9]+)$",line.strip())
            stack =  g.group(1)
            num = g.group(2)                   c
            content = stack.split(";")
            content.reverse()
            ret =  [';'.join(content[n:]).strip() for n in range(len(content))]
            ret.append(" "+num)
            for iterm in ret:
                out.write(iterm)
            out.write("\n")
    out.write("\n")

/** genGraphPaper.groovy - generate an SVG file with the desired output. */

import groovy.xml.* 

def cli = new CliBuilder(usage: "Generate a page of graph paper");
cli.o(longOpt: "output", args: 1, required: true, "output file")
def opt = cli.parse(args)
def o = new File(opt.o)
def output = new MarkupBuilder(o.newWriter()) 

def lineStyles = [
  (1/16): [stroke: "#eef", "stroke-width": 1],
  (1/4):  [stroke: "#ccf", "stroke-width": 1],
  (1):    [stroke: "#aaf", "stroke-width": 1]
]
output.svg(xmlns: "http://www.w3.org/2000/svg", 
           width: "8.5in", height: "11in") {
  lineStyles.keySet().sort().each {
    dim ->
      def xmin = 0
      def ymin = 0
      def xmax = 8.5
      def ymax = 11
      def x1 = 0;
      for (x1 = 0; x1 < xmax; x1 += dim) {
        line((lineStyles[dim] + [
                x1: "${x1}in",
                                 x2: "${x1}in",
                                 y1: "${ymin}in",
                                 y2: "${ymax}in"
              ]))
      }
      for (y1 = 0; y1 < ymax; y1 += dim) {
        line((lineStyles[dim] + [
                y1: "${y1}in",
                                 y2: "${y1}in",
                                 x1: "${xmin}in",
                                 x2: "${xmax}in"
              ]))
      }
  }
  
}

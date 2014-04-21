/*global jQuery*/

// http://en.wikipedia.org/wiki/Scalable_Vector_Graphics


var GRAPH_PAPER_GENERATOR = (function ($) {
    var app = {};
    /** @param graphSpec  a graph specification with certain properties:
     *      width     - the width of the paper
     *      height    - the height of the paper
     *      drawGraph - a function that draws the graph lines.
     */
    app.openGraph = function (graphSpec) {
        var newWindow = window.open('', 'Graph');
        var svgDoc = newWindow.document;
        svgDoc.write('<svg width="' + graphSpec.width
                     + '" height="' + graphSpec.height + '">');
        svgDoc.write('</svg>');
        svgDoc.close();
        var svg = $(newWindow.document).find('svg');
        //graphSpec.drawGraph(svg);
        svg.append($('<line x1="0" y1="0" x2="200" y2="200" style="stroke:rgb(255,0,0);stroke-width:2" />'));
        return newWindow;
    };
    return app;
}(jQuery));

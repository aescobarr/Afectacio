YAHOO.util.Event.onContentReady("containerimg", function () {
    var carousel    = new YAHOO.widget.Carousel("containerimg", {
        animation: {
            speed: 0.5
        }
    });
    carousel.render();
    carousel.show();
});

YAHOO.util.Event.onContentReady("containerdocs", function () {
    var carousel    = new YAHOO.widget.Carousel("containerdocs", {
        animation: {
            speed: 0.5
        }
    });
    carousel.render();
    carousel.show();
});


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hot spots</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pannellum@2.5.6/build/pannellum.css"/>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/pannellum@2.5.6/build/pannellum.js"></script>
    <style>
    #panorama {
        width: 1000px;
        height: 800px;
    }
    </style>
</head>
<body>

<div id="panorama"></div>
<script>
pannellum.viewer('panorama', {
    "type": "equirectangular",
    "panorama": "./라쿤.jpg",
    /*
     * Uncomment the next line to print the coordinates of mouse clicks
     * to the browser's developer console, which makes it much easier
     * to figure out where to place hot spots. Always remove it when
     * finished, though.
     */
    //"hotSpotDebug": true,
    "hotSpots": [
        {
            "pitch": 14.1,
            "yaw": 1.5,
            "type": "info",
            "text": "박물관",
            "URL": "https://artbma.org/"
        },
        {
            "pitch": -9.4,
            "yaw": 222.6,
            "type": "info",
            "text": "Art Museum Drive"
        },
        {
            "pitch": -0.9,
            "yaw": 144.4,
            "type": "info",
            "text": "North Charles Street"
        }
    ]
});
</script>

</body>
</html>
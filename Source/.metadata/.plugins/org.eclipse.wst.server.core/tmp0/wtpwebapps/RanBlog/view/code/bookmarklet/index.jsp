<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <link href="style.css" rel="stylesheet" type="text/css">
  <title>Ace Bookmarklet Builder</title>
</head>
<body>

<div id="wrapper">

<div class="content" style="width: 950px">
    <div class="column1" style="margin-top: 47px">
        <textarea id="textarea" style="width:300px; height:300px">
/**
 * This is Ace injected using a bookmarklet.
 */
function foo() {
    var bar = true;
}</textarea><br>
        SourceUrl: <br>
        <input id="srcURL" style="width:300px" value="http://ajaxorg.github.com/ace-builds/src-noconflict"></input><br>
        <button id="buBuild">Build Link</button> <br> <a href="#"></a>
        <a href="https://github.com/ajaxorg/ace/">
            <div class="fork_on_github" ></div>
        </a>
    </div>
    <div class="column2">
        <h1>Ace Bookmarklet Builder</h1>

        <p id="first">
        <strong>WARNING:</strong> Currently, this is only supported in non IE browsers.
        </p>

        <h2>How to use it:</h2>
        <ul>
            <li>Select the options as you want them to be by default.</li>
            <li>Enter the "SourceUrl". This has to be the URL pointing to build/textarea/src/ (you can leave the default to server the scripts from GitHub).</li>
            <li>Click the "Build Link" button to generate your custom Ace Bookmarklet.</li>
            <li>Drag the generated link to your toolbar or store it somewhere else.</li>
            <li>Go to a page with a textarea element and click the bookmarklet - wait a little bit till the files are loaded.</li>
            <li>Click three times on the textarea you want to replace - Ace will replace it.</li>
            <li>To change settings, just click the red icon in the bottom right corner.</li>
        </ul>
    </div>
</div>
</div>

<script>

function inject(options, callback) {
    var baseUrl = options.baseUrl || "../../src-noconflict";
    
    var load = function(path, callback) {
        var head = document.getElementsByTagName('head')[0];
        var s = document.createElement('script');

        s.src = baseUrl + "/" + path;
        head.appendChild(s);

        s.onload = s.onreadystatechange = function(_, isAbort) {
            if (isAbort || !s.readyState || s.readyState == "loaded" || s.readyState == "complete") {
                s = s.onload = s.onreadystatechange = null;
                if (!isAbort)
                    callback();
            }
        };
    };

    load("ace.js", function() {
        ace.config.loadModule("ace/ext/textarea", function() {
            var event = ace.require("ace/lib/event");
            var areas = document.getElementsByTagName("textarea");
            for (var i = 0; i < areas.length; i++) {
                event.addListener(areas[i], "click", function(e) {
                    if (e.detail == 3) {
                        ace.transformTextarea(e.target, options.ace);
                    }
                });
            }
            callback && callback();
        });
    });
}

// Call the inject function to load the ace files.
var textAce;
inject({}, function () {
    // Transform the textarea on the page into an ace editor.    
    var t = document.querySelector("textarea");
    textAce = ace.require("ace/ext/textarea").transformTextarea(t);
    setTimeout(function(){textAce.setDisplaySettings(true)});
});


document.getElementById("buBuild").onclick = function() {
    var injectSrc = inject.toString().split("\n").join("");
    injectSrc = injectSrc.replace(/\s+/g, " ");

    var options = textAce.getOptions();
    options.baseUrl = document.getElementById("srcURL").value;

    var a = document.querySelector("a");
    a.href = "javascript:(" + injectSrc + ")(" + JSON.stringify(options) + ")";
    a.innerHTML = "Ace Bookmarklet Link";
}

</script>

</body>
</html>
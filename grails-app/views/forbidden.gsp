<!doctype html>
<html>
    <head>
        <title>Page Forbidden</title>
        <meta name="layout" content="main">
        <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
    </head>
    <body>
        <ul class="errors">
            <li>Error: Page Forbidden (403)</li>
            <li>Message: ${flash.error}</li>
            <li>Path: ${request.forwardURI}</li>
        </ul>
    </body>
</html>

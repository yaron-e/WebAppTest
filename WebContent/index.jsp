<!doctype html>
<!--
  Material Design Lite
  Copyright 2015 Google Inc. All rights reserved.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      https://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License
-->
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description"
	content="A front-end template that helps you build fast, modern mobile web apps.">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>

<!-- Add to homescreen for Chrome on Android -->
<meta name="mobile-web-app-capable" content="yes">
<link rel="icon" sizes="192x192"
	href="images/touch/chrome-touch-icon-192x192.png">

<!-- Add to homescreen for Safari on iOS -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-title" content="Material Design Lite">
<link rel="apple-touch-icon-precomposed"
	href="resources/apple-touch-icon-precomposed.png">

<!-- Tile icon for Win8 (144x144 + tile color) -->
<meta name="msapplication-TileImage"
	content="resources/images/touch/ms-touch-icon-144x144-precomposed.png">
<meta name="msapplication-TileColor" content="#3372DF">

<!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
<!--
    <link rel="canonical" href="http://www.example.com/">
    -->

<link
	href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="resources/material.min.css">
<link rel="stylesheet" href="resources/styles.css">
<style>
#view-source {
	position: fixed;
	display: block;
	right: 0;
	bottom: 0;
	margin-right: 40px;
	margin-bottom: 40px;
	z-index: 900;
}
</style>
</head>
<body
	class="mdl-demo mdl-color--grey-100 mdl-color-text--grey-700 mdl-base">
	<%@include file="header.jsp"%>
	<main class="mdl-layout__content"> <br>
	<br>

	<c:forEach items="${errorMsg}" var="errorMsg">
		<p style="color: red;">${errorMsg}</p>
	</c:forEach>

	<form action="LoginServlet" method="post">

		username :<input type="text" name="username"> <br>
		password :<input type="password" name="password"><br> <input
			type="submit" value="Login" id="loginButton">
	</form>


	</main>
	<script src="resources/material.min.js"></script>
	<%@include file="footer.jsp"%>
</body>
</html>

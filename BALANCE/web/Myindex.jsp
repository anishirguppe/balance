


<html>
<head>
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>My Balance Sheet</title>

<link rel="stylesheet" type="text/css" href="js/style.css" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery.dropotron-1.0.js"></script>
<script type="text/javascript" src="js/jquery.slidertron-1.1.js"></script>
<script type="text/javascript">
	$(function() {
		$('#menu > ul').dropotron({
			mode: 'fade',
			globalOffsetY: 11,
			offsetY: -15
		});
		$('#slider').slidertron({
			viewerSelector: '.viewer',
			indicatorSelector: '.indicator span',
			reelSelector: '.reel',
			slidesSelector: '.slide',
			speed: 'slow',
			advanceDelay: 4000
		});
	});
</script>
</head>
<body>
<div id="wrapper">
  <a href="l_viewincome.do">view</a>	
  <div>  <%@include file="jsp/header.jsp"  %>  </div>
	<div id="slider">
		<div class="viewer">
			<div class="reel">
				<div class="slide">
					<img src="images/slide01.jpg" alt="" />
				</div>
				<div class="slide">
					<img src="images/slide02.jpg" alt="" />
				</div>
				<div class="slide">
					<img src="images/slide03.jpg" alt="" />
				</div>
				<div class="slide">
					<img src="images/slide04.jpg" alt="" />
				</div>
				<div class="slide">
					<img src="images/slide05.jpg" alt="" />
				</div>
			</div>
		</div>
		<div class="indicator">
			<span>1</span>
			<span>2</span>
			<span>3</span>
			<span>4</span>
			<span>5</span>
		</div>
	</div>
	<div id="page">
		<div id="content">
			<div class="box">
				<h2>Welcome to Big Business 2.0</h2>
				<p>
					This is <strong>Big Business 2.0</strong>, a free and fully standards-compliant CSS website template by <a href="http://www.freecsstemplates.org">FCT</a>. The pictures in this template are from <a href="http://fotogrph.com/">Fotogrph</a>. This free CSS template is released under a <a href="http://creativecommons.org/licenses/by/3.0/">Creative Commons Attributions 3.0</a> license, so you are pretty much free to do whatever you want with it (even use it commercially) provided you keep all the links in the footer intact. Aside from that, have fun with it :)
				</p>
			</div>
			<div class="box" id="content-box1">
				<h3>Mauris justo</h3>
				<ul class="section-list">
					<li class="first">
						<img class="pic alignleft" src="images/pic01.jpg" width="70" height="70" alt="" />
						<span>Condimentum et porttitor tristique nec aliquet magnis pretium quam nibh.</span>
					</li>
					<li>
						<img class="pic alignleft" src="images/pic02.jpg" width="70" height="70" alt="" />
						<span>Posuere elementum sapien justo tortor nulla fringilla suspendisse nascetur.</span>
					</li>
					<li class="last">
						<img class="pic alignleft" src="images/pic03.jpg" width="70" height="70" alt="" />
						<span>Ipsum quis vestibulum feugiat congue nunc laoreet volutpat lorem ipsum sociis.</span>
					</li>
				</ul>
			</div>
			<div class="box" id="content-box2">
				<h3>Magnis hendrerit erat</h3>
				<p>
					Neque neque ornare penatibus tristique fusce turpis. Purus sagittis euismod at ornare suscipit tempus.
				</p>
				<ul class="list">
					<li class="first"><a href="#">Ipsum phasellus ullamcorper</a></li>
					<li><a href="#">Mollis mattis tempus amet</a></li>
					<li><a href="#">Ipsum aliquet dignissim vitae</a></li>
					<li><a href="#">Orci metus curae sed mollis</a></li>
					<li class="last"><a href="#">Tristique amet venenatis</a></li>
				</ul>
			</div>
			<br class="clearfix" />
		</div>
		<div id="sidebar">
			<div class="box">
				<h3>Cursus magnis</h3>
				<ul class="list">
					<li class="first"><a href="#">Adipiscing tincidunt</a></li>
					<li><a href="#">Euismod elit sollicitudin</a></li>
					<li><a href="#">Dolor magnis et lacinia</a></li>
					<li><a href="#">Mauris ornare aenean</a></li>
					<li class="last"><a href="#">Ante semper fringilla</a></li>
				</ul>
			</div>
			<div class="box">
				<h3>Morbi at varius</h3>
				<div class="date-list">
					<ul class="list date-list">
						<li class="first"><span class="date">2/08</span> <a href="#">Quam sed tempus</a></li>
						<li><span class="date">2/05</span> <a href="#">Lorem et vestibulum</a></li>
						<li><span class="date">2/01</span> <a href="#">Risus aenean tellus</a></li>
						<li class="last"><span class="date">1/31</span> <a href="#">Tristique et primis</a></li>
					</ul>
				</div>
			</div>
		</div>
		<br class="clearfix" />
	</div>
	<div id="page-bottom">
		<div id="page-bottom-content">
			<h3>Magnis hendrerit erat</h3>
			<p>
				Euismod sodales sociis hendrerit pulvinar acursus urna. Consectetur egestas sodales at ornare laoreet turpis. Lorem id sapien ridiculus sagittis imperdiet urna suspendisse. Posuere arcu parturient quam risus. Aliquam nullam magnis integer gravida vulputate felis. Consectetur montes sollicitudin dictum. Auctor sociis hendrerit pulvinar acursus urna lorem ipsum dolor vivamus pulvinar libero. Massa egestas cubilia lacus augue mattis consectetur.
			</p>
		</div>
		<div id="page-bottom-sidebar">
			<h3>Sed interdum</h3>
			<ul class="list">
				<li class="first"><a href="#">Suspendisse ultricies</a></li>
				<li><a href="#">Tortor mollis enim</a></li>
				<li class="last"><a href="#">Lorem enim tempor</a></li>
			</ul>
		</div>
		<br class="clearfix" />
	</div>
</div>
<div id="footer">
	Copyright (c) 2012 www.MyBalance.com. All rights reserved. Design by <a href="">FCT</a>. Photos by <a href="">Fotogrph</a>.
</div>
</body>
</html>

#!/usr/local/bin/perl -w

#/disk1/j/jomendes/public_html/Trab/test.pl 

 $user='teste5';
 $pass='teste5';
 $tofile='C:\Netscape\SuiteSpot\docs\Dfme\Diario\5\5.doc';
 $kilo=1000;
use CGI;
#my $query = new CGI;
#print "Content-type: text/html";
print <<_END;
<html>

<head>
<meta http-equiv="Content-Type"
content="text/html; charset=iso-8859-1">
<meta name="GENERATOR" content="Microsoft FrontPage Express 2.0">
<title>Frames</title>
</head>

<body bgcolor="#FFFFFF" text="#000000">

<form name="Form1">
    <h4>Applix</h4>
 
    <p align="left">
    <a href="Applix/MM.html">M.Market</a><br>
    <a href="Applix/CORP.html">Corporates</a><br>
    <a href="Applix/MC.html">Fx Spot</a><br>
 


    </p>
</form>
<SCRIPT Language="JavaScript">
<!-- Start Hiding from older browsers
//		alert(this.document.name);
// End hiding -->
</SCRIPT>
_END

print "MENDES";
#perl -v;

print <<_END;
</body>
</html>
_END
#print (perl -v) ;
#require ("./Uploads.pl");

#require ("Upload_1.pl");

exit(0);
#--------------------------------------------------------------------
#__END__
#:endofperl
#!/usr/local/bin/perl 
#
# 
# Standard ---------- nao mexer : ------------------------------------
#
        use CGI qw/:standard/;
#        use CGI::Carp 'fatalsToBrowser';
#        $CGI::POST_MAX=1024 * $kilo;  # max 100K posts
#        $CGI::DISABLE_UPLOADS = 1;  # no uploads
#        $query = new CGI;
#        print $query->header;
#        print $query->start_html("Upload_0");

#        &print_prompt($query,$user);

#        &do_work($query,$Nome,$pass,$tofile);

#       print $query->end_html;
print "<BR><b>Terminado<b>";

#-----------------------------------------------------------------------------
sub print_prompt
{
  my($query,$user) = @_; 
        print "<H1> Olá, $user </H1>\n";
        print "<B>Indique a sua Password, e escolha qual o ficheiro  a enviar</B>\n"; 
 print $query->start_multipart_form; #startform;
  print $query->password_field(-name=>'password',
                               -value=>'',
                               -size=>12,
                               -maxlength=>12);
print "<BR><BR>";        
print $query->filefield(-name=>'file_to_upload',
                          -default=>'C:\\',
                          -size=>50,
                          -maxlength=>80);
  print "<BR><BR>";           
  print "<P>",$query->reset;
  print $query->submit('Action','Send_To_Mendes');
  print $query->endform;
  print "<HR>\n";       
}
#------------------------------------------------------------------------------
sub do_work
{
  my($query,$Nome,$Pass,$fileout) = @_;
  my(@values,$key);
  $filename = $query->param('file_to_upload');
  $password = $query->param('password');

#  print "<H2>Here are the current settings in this form</H2>";
#  print "PARAMS: $Nome,$Pass,$fileout<BR><BR>"; 

  foreach $key ($query->param) {
#         print "<STRONG>$key</STRONG> -> ";
         @values = $query->param($key);
#         print join(", ",@values),"<BR>\n";
  }

 if ($password eq $Pass )
 { 
    if ($filename)
    {
      print "<B><H2>Copiando de :</H2></B>$filename <B><H2>Para o server</H2>";       print       print "</B>$fileout</br>";
      use File::Copy;
      copy($filename,$fileout);
    print "<BR><h2>Ok .. Está feito.</h2>";
    }else{print "<B><H2>Desculpe,<Br>mas não me disse qual ficheiro copiar...</H2></B><BR>"}
  }
  else
  {
    print "<B><H2>Erro de Password..  Tente de novo.. </H2></B><BR>";
  }

}
#-------------------------------------------------------------------------------
exit(0);
#-------------------------------------------------------------------------------

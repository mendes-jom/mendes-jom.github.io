##############################################################################
# Cliff's Clock Version 1.01                                                 # 
# Copyright 1998 Shaven Ferret Productions                                   #
# Created 12/11/98          Last Modified 01/04/98                           #
# Available at http://www.shavenferret.com/scripts                           #
##############################################################################
# COPYRIGHT NOTICE                                                           #
# Copyright 1998 Shaven Ferret Productions All Rights Reserved.              #
#                                                                            #
# This script can be used\modified free of charge as long as you don't       #
# change this header thing.  By using this script you agree to indemnify     #
# me from any liability that might arise from its use.  In simple English,   #
# if this script somehow makes your computer run amuck and kill the pope,    #
# it's not my fault.                                                         #
#                                                                            #
# Redistributing\selling the code for this program without prior written     #
# consent is expressly forbidden.                                            #
##############################################################################

Hello.  These are the instructions for how to install and use the clock
script.  You should have the following files...

        * clock.cgi -- the script
        * readme.txt - the file you're reading now

If you're missing any of these files, you can download them from
http://www.shavenferret.com/scripts/clock/

******************************************************************************
* Installation                                                            
******************************************************************************

Open clock.cgi in a text editor.  If perl cannot be found at /usr/bin/perl on
your system, change /usr/bin/perl in the first line to the location of perl.
Now scroll down to line 25.  If you want the date displayed as December 11,
1998, leave this variable as it is.  If you want the date displayed as
12/11/1998, change the 1 in line 25 to a 2.  If you don't want it displayed at
all, change the 1 to a 0.  Scroll down to line 29.  If you don't want the day
of the week displayed, change the 1 to a 0.  Scroll down to line 34.  If you
want the time displayed as 10:15:08 P.M., leave this line as it is.  If you
want the time displayed as 22:15:08, change the 1 in line 34 to a 2.  If you
don't want the time displayed at all, change the 1 in line 34 to a 0.  Now
scroll down to line 38.  If you'd rather have the time displayed before the
date, change the 0 to a 1.  Finally, scroll down to line 41 and enter the text
you want displayed between the time and the date.  If you aren't displaying
both, I suggest deleting this line.

Now upload clock.cgi as ascii, and set its permissions to 755.
Congratulations, you're done!  You'll probably want to put your clock in your
web pages now.  To do so, add the text <!--#exec cgi="/cgi-bin/clock.cgi" -->,
where /cgi-bin/clock.cgi is the URL of clock.cgi *without* the http:// and the
domain.  You may also have to change the page's extension to .shtml.

******************************************************************************
* Troubleshooting                                                            
******************************************************************************

* Clock doesn't appear on the pages where I added it.
        * Click view source, and see if the
          <!--#exec cgi="/cgi-bin/clock.cgi" --> text is still where you added
          it.  If it is, try changing the page's extension to .shtml.  If that
          doesn't work, ask your system administrator what you need to do to
          enable SSI.  If it isn't there, or it's been replaced by something
          like "An error occurred", check the following:
                * Make sure that you changed the first line of clock.cgi to
                  #! and then the path to perl.
                * Make sure that you uploaded the script as ascii.
                * Make sure that you set clock.cgi's permissions to 755.
                * Make sure that you changed /cgi-bin/clock.cgi to the URL,
                  without the http:// or the domain, of clock.cgi.

******************************************************************************

                        If you still need help, go to
                http://www.shavenferret.com/scripts/help.shtml

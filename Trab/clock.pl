#!/usr/local/bin/perl
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

# If you want the date displayed in the format of December 11, 1998, leave the
# next variable as a 1.  If you want it displayed as 12/11/1998, change the
# next variable to a 2.  If you don't want it displayed at all, change the
# next variable to a 0.
$dateformat = 1;

# If you don't want the day of the week displayed, change the next variable to
# a 0.
$weekday = 1;

# If you want the time displayed as 10:15:08 P.M., leave the next variable as
# a 1.  If you want it displayed as 22:15:08, change the next variable to a 2.
# If you don't want it displayed at all, change the next variable to a 0.
$timeformat = 1;

# If you want the date before the time, leave the next variable as a 0.  If
# you want the time before the date, change the next variable to a 1.
$order = 0;

# Change the next variable to whatever you want between the date and time.
$divider = ", ";

##############################################################################
# Congratulations!  You've finished defining the variables.  If you want to, #
# you can continue screwing with the script, but it isn't necessary.         #
##############################################################################

print "Content-type: text/html\n\n";
@months = ('January','February','March','April','May','June','July','August','September','October','November','December');
@days = ('Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday');
($sec,$min,$hour,$day,$month,$year,$day2) = (localtime(time))[0,1,2,3,4,5,6];
if ($sec < 10) { $sec = "0$sec"; }
if ($min < 10) { $min = "0$min"; }
if ($hour < 10) { $hour = "0$hour"; }
if ($day < 10) { $day = "0$day"; }
$year += "1900";
if ($order) { &time; &divide; &date; }
else { &date; &divide; &time; }
sub date {
        if ($dateformat) {
                if ($weekday) { print "$days[$day2], "; }
                if ($dateformat == 1) { print "$months[$month] $day, $year"; }
                else {
                        $month++;
                        print "$month/$day/$year";
                }
        }
}
sub time {
        if ($timeformat == 2) { print "$hour:$min:$sec"; }
        elsif ($timeformat == 1) {
                if ($hour >= 12) { $ex = "P.M."; }
                else { $ex = "A.M."; }
                if ($hour == 0) { $hour = 12; }
                if ($hour > 12) { $hour -= 12; }
                print "$hour:$min:$sec $ex";                        
        }
}
sub divide {
        print "$divider";
}
 
#NoEnv  ; Recommended for performance and compatibility with future AutoHotkey releases.
SendMode Input  ; Recommended for new scripts due to its superior speed and reliability.
SetWorkingDir %A_ScriptDir%  ; Ensures a consistent starting directory.
#persistent

x=
y=
mx=
my=

^space::

MouseGetPos, mx, my, , , 

CoordMode, pixel, Screen

ImageSearch, x, y, 0, 0, %A_ScreenWidth%, %A_ScreenHeight%, thumb.png


x:=x+45
y:=y+18


CoordMode, Mouse, Screen

MouseClick , left , %x%, %y%, 1, 0, , 
MouseMove, mx, my , 0, 

mx=
my=

return
#NoEnv  ; Recommended for performance and compatibility with future AutoHotkey releases.
SendMode Input  ; Recommended for new scripts due to its superior speed and reliability.
SetWorkingDir %A_ScriptDir%\res  ; Ensures a consistent starting directory.
#NoTrayIcon

param = %1%

if (param="")
{
Run, %A_ScriptDir%\res\AutoHotkey.exe kickstarter.module,, 
}
else
{
Run, %A_ScriptDir%\res\AutoHotkey.exe kickstarter.module %param%,, hide
}
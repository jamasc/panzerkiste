moin

panzer faehrt jetzt mit offset und allem. ich hab den offset in prozent gemacht, d.h. alles unter einem prozent von nem pixel geht verloren

die anfangswerte fuer geschwindigkeit und anfangsposition werden im konstruktor von panzer erstellt, weis nicht ob wir so lassen sollen. wenn wir so lassen, dann auf jeden fall mit standartwerten und nicht so wie grade ist, dass panzer mit argumenten in Game aufgerufen wird


CURSOR fork:
-Helper class: fuer verschiedenste sachen die nicht zb im Main erledigt werden sollen. hat grade nur ne methode, um cursor image zu holen und zwei unbenutzte methoden um schussbestaetigungs image zu holen und unsichtbaren cursor zu erstellen

-Main class: nutzt Helper um neuen cursor zu erstellen und zu benutzen

-Game class: initiiert MouseHandler und legt den als mouse motion listener im kostruktor fest

-Panzer class: hab ganz viel unnuetzen bs rausgeschmissen. hat jetzt nur noch paar private properties und setter methoden fuer richtung und aim. gezeichnet wird nur ein quadrat und eine linie zum fadenkreuz. (linie wird spaeter obvi geupdatet)

-MouseHandler: weis die maus position sobald die sich aendert und ruft setAim von Panzer auf.

-res/aim: cursor images

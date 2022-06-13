import kivy
from kivy.uix.screenmanager import ScreenManager, Screen
from kivymd.app import MDApp
from kivy.core.window import Window
import ScreenDarEntrada as scre
import TablaBase as scrp
import ScreenDarSalida as scrs
import ScreenAgregarTarifa as scra


Window.size = (1200, 700)
class Main(ScreenManager):
    def __init__(self,**kwargs):
        super(Main,self).__init__()
        self.TB=scrp.TablaBase(self)
        self.DE=scre.ScreenDarEntrada(self)
        self.DS=scrs.ScreenDarSalida(self)
        self.AT=scra.ScreenAgregarTarifa(self)

        wid=Screen(name="inicio")
        wid.add_widget(self.TB)
        self.add_widget(wid)

        wid=Screen(name="dar_entrada")
        wid.add_widget(self.DE)
        self.add_widget(wid)

        wid=Screen(name="dar_salida")
        wid.add_widget(self.DS)
        self.add_widget(wid)

        wid=Screen(name="agregar_tarifa")
        wid.add_widget(self.AT)
        self.add_widget(wid)


    
    def goto_inicio(self):
        self.current="inicio"

    def goto_dar_entrada(self):
        self.current="dar_entrada"
    
    def goto_dar_salida(self):
         self.current="dar_salida"

    def goto_agregar_tarifa(self):
         self.current="agregar_tarifa"
    


class MainApp(MDApp):
    title = "Scroll view"
    def build(self):
        return Main()
        
if __name__ == "__main__":
    MainApp().run()
from kivy.uix.boxlayout import BoxLayout
from kivy.lang import Builder
from kivy.uix.label import Label
from kivymd.app import MDApp
from kivy.clock import Clock
import sys
sys.path.insert(1,'./clases')
import CRUD as bd
import BarraOpciones as bo
import ImagenCarga as ic


class TablaBase(BoxLayout):
    def __init__(self,menu,**kargs):
    #def __init__(self,**kargs):
        self.root=Builder.load_file('./estilos/TablaBase.kv')
        self.color_text=(1,1,1)
        self.color_label=(1,0.4471,0.3686)
        
        super(TablaBase,self).__init__(**kargs)
        #self.mostrar_registros()
        Clock.schedule_interval(self.mostrar_registros, 0.5)
        self.menu=menu
        self.B=bo.BarraOpciones(self.menu)
        self.ids.barra_opciones.add_widget(self.B)
    
    def mostrar_registros(self,dt):
        self.ids.container_y.clear_widgets()
        registros=bd.CRUD()
        registro=registros.mostrar_bd()
        for x in range(0,len(registro)):
            for i in registro[x]:
                self.ids.container_y.add_widget(Label(text=str(i),font_size=12,color=(0,0,0)))
                #print(i)

        #self.IC=ic.ImagenCarga()
        #self.ids.box.add_widget(self.IC)
        #self.B=bo.BarraOpciones(self.menu)
        #self.ids.elemento_izq.add_widget(self.B)

# class MainApp(MDApp):
#     title = "Scroll view"
#     def build(self):
#         return TablaBase()
        
# if __name__ == "__main__":
#     MainApp().run()
from kivy.uix.anchorlayout import AnchorLayout
from kivymd.uix.textfield import MDTextField
from kivy.lang import Builder
from kivymd.app import MDApp
import sys
sys.path.insert(1,'./clases')
import CRUD as bd

class ScreenDarSalida(AnchorLayout):
    def __init__(self,menu,**kwargs):
        self.menu=menu
        self.root=Builder.load_file('./estilos/ScreenDarSalida.kv')
        super(ScreenDarSalida,self).__init__()
        self.placa=MDTextField(hint_text="Escriba aquí el número de placa",
                            pos_hint={'center_x':0.5 , 'center_y':0.5 },
                            size_hint=(0.5,1 )
                            )
        self.add_widget(self.placa)
    def dar_salida(self,obj):
        registro=bd.CRUD()
        registro.registro_salida(self.placa.text)
    def cancelar(self):
         self.menu.goto_inicio()


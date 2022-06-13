from kivy.uix.anchorlayout import AnchorLayout
from kivymd.uix.textfield import MDTextField
from kivy.lang import Builder
import sys
sys.path.insert(1,'./clases')
import tarifa as tf

class ScreenAgregarTarifa(AnchorLayout):
    def __init__(self,menu, **kwargs):
        self.menu=menu
        self.root=Builder.load_file('./estilos/ScreenAgregarTarifa.kv')
        super(ScreenAgregarTarifa,self).__init__()
        self.tarifa=MDTextField(hint_text="Escriba aquí el precio de la tarifa",
                            pos_hint={'center_x':0.5 , 'center_y':0.5 },
                            size_hint=(0.5,1 )
                            )
        self.add_widget(self.tarifa)
    def agregar_tarifa(self,obj):
        tarifa=tf.tarifa()
        tarifa.cambiar_tarifa(self.tarifa.text)
        
    def cancelar(self):
         self.menu.goto_inicio()

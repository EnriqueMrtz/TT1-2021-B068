from kivy.uix.anchorlayout import AnchorLayout
from kivymd.uix.textfield import MDTextField
from kivy.lang import Builder
import sys
sys.path.insert(1,'./clases')
import CRUD as bd

class ScreenDarEntrada(AnchorLayout):
    def __init__(self,menu, **kwargs):
        self.menu=menu
        self.root=Builder.load_file('./estilos/ScreenDarEntrada.kv')
        super(ScreenDarEntrada,self).__init__()
        self.placa=MDTextField(hint_text="Escriba aquí el número de placa",
                            pos_hint={'center_x':0.5 , 'center_y':0.5 },
                            size_hint=(0.5,1 )
                            )
        self.add_widget(self.placa)
    def dar_entrada(self,obj):
        registro=bd.CRUD()
        registro.registro_entrada(self.placa.text)
        
        
    def cancelar(self):
         self.menu.goto_inicio()

# class MainApp(MDApp):
#     title = "Scroll view"
#     def build(self):
#         return ScreenDarEntrada()
        
# if __name__ == "__main__":
#     MainApp().run()
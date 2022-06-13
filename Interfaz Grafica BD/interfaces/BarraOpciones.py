import kivy
from kivy.uix.boxlayout import BoxLayout
from kivy.lang import Builder
from kivymd.app import MDApp
class BarraOpciones(BoxLayout):
    def __init__(self,menu,**kwargs):
    #def __init__(self,**kargs):
        self.menu=menu
        self.root=Builder.load_file('./estilos/BarraOpciones.kv')
        self.color_text=(1,1,1)
        super(BarraOpciones,self).__init__()
        
    def dar_entrada(self):
        self.menu.goto_dar_entrada()
    def dar_salida(self):
        self.menu.goto_dar_salida()
    def agregar_tarifa(self):
        self.menu.goto_agregar_tarifa()


# class MainApp(MDApp):
#     title = "Scroll view"
#     def build(self):
#         return BarraOpciones()
        
# if __name__ == "__main__":
#     MainApp().run()
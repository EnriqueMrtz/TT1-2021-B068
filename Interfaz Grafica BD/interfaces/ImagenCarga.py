from kivy.uix.boxlayout import BoxLayout
import kivy
from kivy.uix.label import Label
from tkinter import Tk
from kivy.uix.image import Image
import tkinter as tk
import tkinter.filedialog
from kivy.lang import Builder

class ImagenCarga(BoxLayout):
    def __init__(self,**kwargs):
        self.root=Builder.load_file('./estilos/ImagenCarga.kv')
        super(ImagenCarga,self).__init__(**kwargs)
        self.img=Image(source='./icons/gato.jpg',nocache=True,allow_stretch=True,keep_ratio=False)
        self.add_widget(self.img)

    def abrirArchivo(self,*args):
        Tk().withdraw()
        archivo_abierto = tk.filedialog.askopenfilename(initialdir="/", 
                      title="Seleccione archivo",
                      filetypes=(("png files", "*.png"),("all files", "*.*")))
        if archivo_abierto:
            self.remove_widget(self.img)
            self.img=Image(source= archivo_abierto,nocache=True,allow_stretch=True,keep_ratio=False)
            self.add_widget(self.img)
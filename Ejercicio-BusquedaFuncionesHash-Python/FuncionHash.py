from typing import List

class FuncionesHash:
    def __init__(self):
        self.tam = 11
        self.indices = [None] * self.tam
        self.datos = [None] * self.tam

    def agregar(self,clave,dato):
        valorHash = self.funcionHash(clave,len(self.indices))
        if self.indices[valorHash] == None:
            self.indices[valorHash] = clave
            self.datos[valorHash] = dato
        else:
            if self.indices[valorHash] == clave:
                self.datos[valorHash] = dato
            else:
                proximoIndice = self.rehash(valorHash,len(self.indices))
                while self.indices[proximoIndice] != None and \
                        self.indices[proximoIndice] != clave:
                    proximoIndice = self.rehash(proximoIndice,len(self.indices))
                    if self.indices[proximoIndice] == None:
                        self.indices[proximoIndice]=clave
                        self.datos[proximoIndice]=dato
                    else:
                        self.datos[proximoIndice] = dato

    def funcionHash(self,clave,tam):
        return clave%tam

    def rehash(self,hashViejo,tam):
        return (hashViejo+1)%tam

    def obtener(self,clave):
      indiceInicio = self.funcionHash(clave,len(self.indices))
      dato = None
      parar = False
      encontrado = False
      posicion = indiceInicio
      while self.indices[posicion] != None and  \
              not encontrado and not parar:
          if self.indices[posicion] == clave:
              encontrado = True
              dato = self.datos[posicion]
          else:
              posicion=self.rehash(posicion,len(self.indices))
              if posicion == indiceInicio:
                  parar = True
                  return dato

    def __getitem__(self,clave):
        return self.obtener(clave)

    def __setitem__(self,clave,dato):
        self.agregar(clave,dato)

funcion=FuncionesHash()
funcion[0]=25
funcion[1]=14
funcion[2]=96
funcion[3]=300
funcion[4]=1
funcion[5]=12
funcion[6]=8
funcion[7]=15
print(funcion.indices)
print(funcion.datos)
print(funcion[5])
print(funcion[1])
funcion[5]=500
print(funcion[5])
print(funcion[7])
import React from "react";
import Header from "./Header";
import Image from "next/image";

const Layout = ({ children }) => {
  return (
    <>
      <Header />

      <div className="absolute w-full h-screen">
        {/* Imagen de fondo */}
        <div className="absolute inset-0 z-0">
          <Image
            className="w-full h-full object-cover"
            src="/assets/tenedores.png"
            alt="Fondo de tenedores"
            quality={100}
            layout="fill" // Utiliza "fill" para cubrir todo el contenedor
          />
        </div>

        {/* Contenido principal */}
        <div className="relative z-10">
          {children}
        </div>
      </div>
    </>
  );
};

export default Layout;

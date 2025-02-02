import Image from "next/image"
import logo from "../public/images/logo.svg"

export default function Page() {
  return (
    <div style={{
      textAlign: "center",
      display: "flex",
      flexDirection: "column",
      justifyContent: "center",
      alignItems: "center",
    }}>
      <Image src={logo} alt="NutriWise" />
      <p style={{
        fontSize: "2em",
        textShadow: "1px 1px 2px white",
      }}><b>Te acompañamos a planificar tus comidas de manera fácil y efectiva.</b></p>
      <button style={{
        borderRadius: "30px"
      }}>Genera tu Receta</button>
    </div>
  )
}

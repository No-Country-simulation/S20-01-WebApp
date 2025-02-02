import Link from "next/link"
import Image from "next/image"
import styles from "./landing.module.css"
import logo from "../public/images/logo.svg"

export default function Page() {
  return (
    <div className={styles.logoWrapper}>
      <Image src={logo} alt="NutriWise Logo" />
      <p><b>Te acompañamos a planificar tus comidas de manera fácil y efectiva.</b></p>
      <Link href="/receta" className={styles.button}>Genera tu receta</Link>
    </div>
  )
}

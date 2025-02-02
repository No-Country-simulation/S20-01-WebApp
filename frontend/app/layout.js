import styles from "./global.css"
import background from "../public/images/background.svg"
import { Great_Vibes, Inter } from "next/font/google"

const great_vibes = Great_Vibes({
  subsets: ["latin"],
  weight: "400",
  variable: "--font-great",
})

const inter = Inter({
  subsets: ["latin"],
  weight: "400",
  variable: "--font-inter",
})

export const metadata = {
  title: "NutriWise",
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body style={{
        backgroundImage: `url(${background.src})`,
        backgroundPosition: "center",
        backgroundRepeat: "repeat",
      }}>
        <header className={great_vibes.className}>
          <h1><span>Nutri</span>Wise</h1>
          <p>Nutrición sabia, salud en cada elección</p>
        </header>
        <main className={inter.className}>
          {children}
        </main>
      </body>
    </html>
  );
}

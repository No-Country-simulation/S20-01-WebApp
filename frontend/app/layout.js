import "./pico.green.min.css"
import background from "../public/images/background.svg"

export const metadata = {
  title: "NutriWise",
};

export default function RootLayout({ children }) {
  return (
    <html lang="en" data-theme="light">
      <body style={{
        backgroundImage: `url(${background.src})`,
        backgroundPosition: "center",
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
        height: "100vh",
        width: "100vw",
      }}>
        <header className="container-fluid" style={{
          backgroundColor: "#398712",
          textAlign: "center",
          borderRadius: "0 0 30px 30px",
        }}>
          <h1 style={{
            color: "#FFFFFF",
          }}>NutriWise</h1>
          <p style={{
            color: "#FFFFFF",
          }}>Nutrición sabia, salud en cada elección</p>
        </header>
        <main className="container-fluid">
          {children}
        </main>
      </body>
    </html>
  );
}

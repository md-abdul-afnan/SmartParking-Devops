from reportlab.lib.pagesizes import A4
from reportlab.pdfgen import canvas
from reportlab.lib.units import cm
from pathlib import Path


def create_pdf_from_markdown(markdown_path: Path, output_path: Path) -> None:
    text = markdown_path.read_text(encoding="utf-8").splitlines()
    c = canvas.Canvas(str(output_path), pagesize=A4)
    width, height = A4
    margin_x = 2 * cm
    y = height - 2 * cm
    line_height = 14

    for raw_line in text:
        line = raw_line.replace("**", "").replace("`", "")
        if line.strip() == "---":
            line = "-" * 90

        if y < 2 * cm:
            c.showPage()
            y = height - 2 * cm

        c.drawString(margin_x, y, line[:120])
        y -= line_height

    c.save()


if __name__ == "__main__":
    root = Path(__file__).resolve().parents[1]
    md_file = root / "REPORT.md"
    pdf_file = root / "SmartParking_DevOps_Report.pdf"
    create_pdf_from_markdown(md_file, pdf_file)
    print(f"Generated PDF: {pdf_file}")

import { Button } from "react-bootstrap";
import { getPDF } from "../../../api/adminAPI";

function PDFExportButton(props) {
  function exportPdf() {
    getPDF(props.menu);
  }
  return <Button onClick={exportPdf}>Export PDF</Button>;
}
export default PDFExportButton;

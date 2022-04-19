import { Button } from "react-bootstrap";
import { getPDF } from "../../../api/adminAPI";

function PDFExportButton(props) {
  function exportPdf() {
    getPDF(props.menu);
  }
  return <Button onClick={exportPdf}>Export PDF</Button>;
}
export default PDFExportButton;
/* <object data="http://africau.edu/images/default/sample.pdf" type="application/pdf" width="100%" height="100%">
<p>Alternative text - include a link <a href="http://africau.edu/images/default/sample.pdf">to the PDF!</a></p>
</object>*/

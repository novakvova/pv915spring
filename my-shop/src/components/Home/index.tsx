// import axios from 'axios';
import * as React from "react";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Modal from "@mui/material/Modal";
import Button from "@mui/material/Button";
import "cropperjs/dist/cropper.min.css";
import Cropper from "cropperjs";

const HomePage: React.FC = () => {
  // React.useEffect(() => {
  //     console.log("Begin");
  //     axios.post("http://localhost:8083/create", {name: "Сало"},
  //         {
  //             headers: {
  //                 "Content-type": "application/json"
  //               }
  //         })
  //         .then((res)=> console.log("res", res));
  // });

  const style = {
    position: "absolute" as "absolute",
    top: "50%",
    left: "50%",
    transform: "translate(-50%, -50%)",
    width: 600,
    bgcolor: "background.paper",
    border: "2px solid #000",
    boxShadow: 24,
    p: 4,
  };
  const imgRef = React.useRef<HTMLImageElement>(null);

  const handleModal = async () => {
    //console.log("нажали");
    await setOpen(true);
    const cropper = new Cropper(imgRef.current as HTMLImageElement, {});
  }

  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <>
      <h1>Головна сторінка</h1>
      <Button variant="contained" onClick={handleModal}>
        Модалка
      </Button>

      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <Typography id="modal-modal-title" variant="h6" component="h2">
            Text in a modal
          </Typography>
          {/* <Typography id="modal-modal-description" sx={{ mt: 2 }}>
              Duis mollis, est non commodo luctus, nisi erat porttitor ligula.
            </Typography> */}
          <div>
            <img
              width="100%"
              ref={imgRef}
              src="https://vovalohika.tk/images/600_ixdj2v4m.wck.jpeg"
            />
          </div>
        </Box>
      </Modal>
    </>
  );
};

export default HomePage;
